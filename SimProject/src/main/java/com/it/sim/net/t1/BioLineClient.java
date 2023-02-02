package com.it.sim.net.t1;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class BioLineClient {
    public static void main(String[] args) {
        try(Socket socket =  new Socket("127.0.0.1", 8899);
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8))
        ) {
            while (true) {
                String lineData = bufferedReader.readLine();
                bufferedWriter.write(lineData);
                // bufferedWriter.write("\n");
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
//            socket.shutdownOutput();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

