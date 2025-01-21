package br.com.alura.config;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Envloader {
    private final Map<String, String> variables = new HashMap<>();

    public Envloader(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty() || line.startsWith("#")) {
                    continue; // Ignora linhas vazias ou comentários
                }
                String[] parts = line.split("=", 2); // Divide pelo "="
                if (parts.length == 2) {
                    variables.put(parts[0].trim(), parts[1].trim());
                }
            }
        }
    }

    public String get(String key) {
        return variables.get(key);
    }
}