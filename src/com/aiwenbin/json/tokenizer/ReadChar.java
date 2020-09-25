package com.aiwenbin.json.tokenizer;

import java.io.IOException;
import java.io.Reader;

public class ReadChar {
    private static final int BUFFER_SIZE = 1024;
    private Reader reader;
    private char[] buffer;
    //    下标
    private int index;
    private int size;


    public ReadChar(Reader reader) {
        this.reader = reader;
        buffer = new char[BUFFER_SIZE];
    }

    /**
     * 返回pos下标处的字符
     *
     * @return
     */
    public char peek() {
        if (index - 1 >= size) {
            return (char) -1;
        }

        return buffer[Math.max(0, index - 1)];
    }

    public char next() throws IOException {
        if (!hasMore()) {
            return (char) -1;
        }

        return buffer[index++];
    }

    public void back() {
        index = Math.max(0, --index);
    }

    public boolean hasMore() throws IOException {
        if (index < size) {
            return true;
        }

        fillBuffer();
        return index < size;
    }

    /**
     * 填充buffer数组
     *
     * @throws IOException
     */
    private void fillBuffer() throws IOException {
        int n = reader.read(buffer);
        if (n == -1) {
            return;
        }
        index = 0;
        size = n;
    }

}
