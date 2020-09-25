package com.aiwenbin.json;

import com.aiwenbin.json.parse.Parser;
import com.aiwenbin.json.tokenizer.ReadChar;
import com.aiwenbin.json.tokenizer.TokenList;
import com.aiwenbin.json.tokenizer.Tokenizer;

import java.io.IOException;
import java.io.StringReader;

public class JsonParser {
    private Tokenizer tokenizer = new Tokenizer();

    private Parser parser = new Parser();

    public Object fromJson(String json) throws IOException {
        ReadChar readChar = new ReadChar(new StringReader(json));
        TokenList tokens = tokenizer.getTokenStream(readChar);
        return parser.parse(tokens);
    }
}
