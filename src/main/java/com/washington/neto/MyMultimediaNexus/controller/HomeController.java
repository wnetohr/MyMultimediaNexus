package com.washington.neto.MyMultimediaNexus.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/home")
    public String home() {
        return """
            <!DOCTYPE html>
            <html lang="pt-BR">
            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>My Multimedia Nexus</title>
                <style>
                    body {
                        font-family: Arial, sans-serif;
                        background-color: #f4f4f4;
                        margin: 0;
                        padding: 20px;
                    }
                    h1 {
                        color: #333;
                    }
                    p {
                        font-size: 1.2em;
                        color: #555;
                    }
                    .container {
                        max-width: 800px;
                        margin: 0 auto;
                        background: white;
                        padding: 20px;
                        border-radius: 8px;
                        box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
                    }
                </style>
            </head>
            <body>
                <div class="container">
                    <h1>Bem-vindo ao My Multimedia Nexus!</h1>
                    <p>Explore uma variedade de mídias, incluindo:</p>
                    <ul>
                        <li>Filmes</li>
                        <li>Séries</li>
                        <li>Animes</li>
                        <li>Jogos</li>
                        <li>Livros</li>
                    </ul>
                    <p>Nosso objetivo é conectar você a diferentes tipos de conteúdo multimídia de forma fácil e rápida.</p>
                    <p>Comece a explorar agora!</p>
                </div>
            </body>
            </html>
        """;
    }
}
