package com.aiwenbin.json.tokenizer;

import com.aiwenbin.json.exception.JsonPareseException;
import com.aiwenbin.mulit_status_example.I;

import javax.swing.text.html.HTMLWriter;
import java.io.IOException;

/**
 * 词法解析类
 */
public class Tokenizer {
    private ReadChar readChar;
    private TokenList tokenList;

    public TokenList getTokenStream(ReadChar readerChar) throws IOException {
        this.readChar = readerChar;
        tokenList = new TokenList();

        // 词法解析，获取token流
        tokenizer();

        return tokenList;
    }

    /**
     * 将JSON文件解析成token流
     *
     * @throws IOException
     */
    private void tokenizer() throws IOException {
        Token token;
        do {
            token = start();
            tokenList.add(token);
        } while (token.getTokenType() != TokenType.END_DOCUMENT);
    }

    private Token start() throws IOException {
        char ch;
        while (true) {
            if (!readChar.hasMore()) {
                return new Token(TokenType.END_DOCUMENT, null);
            }

            ch = readChar.next();
            if (!isWhiteSpace(ch)) {
                break;
            }
        }

        switch (ch) {
            case '{':
                return new Token(TokenType.BEGIN_OBJECT, String.valueOf(ch));
            case '}':
                return new Token(TokenType.END_OBJECT, String.valueOf(ch));
            case '[':
                return new Token(TokenType.BEGIN_ARRAY, String.valueOf(ch));
            case ']':
                return new Token(TokenType.END_ARRAY, String.valueOf(ch));
            case ',':
                return new Token(TokenType.SEP_COMMA, String.valueOf(ch));
            case ':':
                return new Token(TokenType.SEP_COLON, String.valueOf(ch));
            case 'n':
                return readNull();
            case 't':
            case 'f':
                return readBoolean();
            case '"':
                return readString();
            case '-':
                return readNumber();
        }

        if (isDigit(ch)) {
            return readNumber();
        }

        throw new JsonPareseException("Illegal character");
    }

    private boolean isWhiteSpace(char ch) {
        return (ch == ' ' || ch == '\t' || ch == '\r' || ch == '\n');
    }

    private Token readString() throws IOException {
        StringBuilder sb = new StringBuilder();
        while (true) {
            char ch = readChar.next();
            if (ch == '\\') {
                if (!isEscapte()) {
                    throw new JsonPareseException("Invalid escape chararcter");
                }
                sb.append('\\');
                ch = readChar.peek();
                sb.append(ch);
                if (ch == 'u') {
                    for (int i = 0; i < 4; i++) {
                        ch = readChar.next();
                        if (isHex(ch)) {
                            sb.append(ch);
                        } else {
                            throw new JsonPareseException("Invalid character");
                        }
                    }
                }
            } else if (ch == '"') {
                return new Token(TokenType.STRING, sb.toString());
            } else if (ch == '\r' || ch == '\n') {
                throw new JsonPareseException("Invalid character");
            } else {
                sb.append(ch);
            }
        }
    }

    /**
     * 判断是否有乱转义的字符
     *
     * @return
     * @throws IOException
     */
    private boolean isEscapte() throws IOException {
        char ch = readChar.next();
        return (ch == '"' || ch == '\\' || ch == 'u' || ch == 'r'
                || ch == 'n' || ch == 'b' || ch == 't' || ch == 'f' || ch == '/');
    }

    /**
     * 判断该字符串是否为16进制数
     * TODO: 也可能为8进制数等, 该如何处理
     *
     * @param ch
     * @return
     */
    private boolean isHex(char ch) {
        return ((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'f') || (ch >= 'A' && ch <= 'F'));
    }


    private Token readNumber() throws IOException {
        char ch = readChar.peek();
        StringBuilder sb = new StringBuilder();
        if (ch == '-') {
            sb.append(ch);
            ch = readChar.next();
            if (ch == '0') {
                sb.append(ch);
                sb.append(readFracAndExp());
            } else if (isDigitOneToNine(ch)) {
                do {
                    sb.append(ch);
                    ch = readChar.next();
                } while (isDigit(ch));
                if (ch != (char) -1) {
                    readChar.back();
                    sb.append(readFracAndExp());
                }
            } else {
                throw new JsonPareseException("Invalid minus number");
            }
        } else if (ch == '0') {
            sb.append(ch);
            sb.append(readFracAndExp());
        } else {
            do {
                sb.append(ch);
                ch = readChar.next();
            } while (isDigit(ch));
            if (ch != (char) -1) {
                readChar.back();
                sb.append(readFracAndExp());
            }
        }

        return new Token(TokenType.NUMBER, sb.toString());
    }

    /**
     * 判断是否是指数
     *
     * @param ch
     * @return
     */
    private boolean isExp(char ch) {
        return ch == 'e' || ch == 'E';
    }

    /**
     * 读取指数形式的数据
     *
     * @return
     * @throws IOException
     */
    private String readExp() throws IOException {
        StringBuilder sb = new StringBuilder();
        char ch = readChar.next();
        if (ch == '+' || ch == '-') {
            sb.append(ch);
            ch = readChar.next();
            if (isDigit(ch)) {
                do {
                    sb.append(ch);
                    ch = readChar.next();
                } while (isDigit(ch));

                if (ch != (char) -1) {
                    readChar.back();
                }
            } else {
                throw new JsonPareseException("e or E");
            }
        } else {
            throw new JsonPareseException("e or E");
        }

        return sb.toString();
    }

    private String readFracAndExp() throws IOException {
        StringBuilder sb = new StringBuilder();
        char ch = readChar.next();
        if (ch == '.') {
            sb.append(ch);
            ch = readChar.next();
            if (!isDigit(ch)) {
                throw new JsonPareseException("Invalid frac");
            }
            do {
                sb.append(ch);
                ch = readChar.next();
            } while (isDigit(ch));

            if (isExp(ch)) {
                sb.append(ch);
                sb.append(readExp());
            } else {
                if (ch != (char) -1) {
                    readChar.back();
                }
            }
        } else {
            readChar.back();
        }

        return sb.toString();
    }

    private boolean isDigit(char ch) {
        return ch >= '0' && ch <= '9';
    }

    private boolean isDigitOneToNine(char ch) {
        return ch >= '1' && ch <= '9';
    }

    /**
     * 解析JSON格式中的Boolean值,
     * 判断是为true 还是 false
     *
     * @return
     * @throws IOException
     */
    private Token readBoolean() throws IOException {
        if (readChar.peek() == 't') {
            if (!(readChar.next() == 'r' && readChar.next() == 'u' && readChar.next() == 'e')) {
                throw new JsonPareseException("Invalid json string");
            }

            return new Token(TokenType.BOOLEAN, "true");
        } else {
            if (!(readChar.next() == 'a' && readChar.next() == 'l'
                    && readChar.next() == 's' && readChar.next() == 'e')) {
                throw new JsonPareseException("Invalid json string");
            }

            return new Token(TokenType.BOOLEAN, "false");
        }

    }

    /**
     * 词法分析器在读取字符n后，期望后面的三个字符分别是u,l,l，与 n 组成词 null。
     * 如果满足期望，则返回类型为 NULL 的 Token，否则报异常。
     *
     * @return
     * @throws IOException
     */
    private Token readNull() throws IOException {
        if (!(readChar.next() == 'u' && readChar.next() == 'l' && readChar.next() == 'l')) {
            throw new JsonPareseException("Invalid json string");
        }

        return new Token(TokenType.NULL, "null");
    }


}
