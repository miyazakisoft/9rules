package com.github.ninerules.cli;

import static com.github.ninerules.cli.Option.HELP_OPTION;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.stream.Stream;

public class HelpPrinter {
    public boolean printIfSpecified(CommandLines cli){
        if(!cli.hasOption(HELP_OPTION)) return false;
        printHelp();
        return true;
    }

    public void printHelp(){
        try {
            openAndPrintThem(getClass().getResource("/resources/help.txt"));
        } catch (IOException e) { }
    }

    private void openAndPrintThem(URL location) throws IOException{
        try(BufferedReader in = new BufferedReader(new InputStreamReader(location.openStream()))){
            printLines(in.lines());
        }
    }

    private void printLines(Stream<String> stream) throws IOException{
        stream.forEach(line -> System.out.println(line));
    }
}