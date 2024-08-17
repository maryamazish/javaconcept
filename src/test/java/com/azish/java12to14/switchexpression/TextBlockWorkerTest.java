package com.azish.java12to14.switchexpression;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TextBlockWorkerTest {
    @Test
    void html_Success(){
        var html = TextBlockWorker.html();
        assertEquals(8,html.lines().count());//چک کردن تعداد خطها
    }
}
