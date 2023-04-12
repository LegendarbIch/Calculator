package controller;

import model.write.WriterExpressionService;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteController {
    private final WriterExpressionService writerExpressionService;

    public WriteController(WriterExpressionService writerExpressionService){
        this.writerExpressionService = writerExpressionService;
    }

    public void WriteToFile(String str) {
        writerExpressionService.write(str);
    }
}
