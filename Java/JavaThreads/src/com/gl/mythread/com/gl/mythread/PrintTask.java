package com.gl.mythread;

public class PrintTask  extends  Thread{
    Sharedprinter sp;
    String content;
    int pageCount;

    public PrintTask(Sharedprinter sp, String content ,int pageCount) {
        this.sp=sp;
        this.content=content;
        this.pageCount=pageCount;
    }
    @Override
    public void run(){
        sp.printmyDocument(content, pageCount);
    }



}
