<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html" encoding="UTF-8"/>
    <xsl:template match="/">
        <html lang="ca">
            <head>
                <meta charset="UTF-8"/>
                <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
                <title>Llista d'alumnes</title>
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-DkkNc0mt4OXFwEsGTXNVCyoy6zQ8d+36tHf0T+dTKmBnjqG+EsE5Fzo+WIR0FL5K" crossorigin="anonymous"/>
                <style>
                    /* Animació d'entrada de la pàgina */
                    body {
                    animation: fadeIn 1s ease-in-out;
                    display: flex;
                    justify-content: center;
                    align-items: center;
                    min-height: 100vh;
                    background-color: #f5f5f5;
                    }

                    @keyframes fadeIn {
                    from {
                    opacity: 0;
                    }
                    to {
                    opacity: 1;
                    }
                    }

                    /* Estil per la taula */
                    table {
                    margin-top: 20px;
                    width: 80%;
                    max-width: 900px;
                    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
                    animation: slideIn 0.5s ease-in-out;
                    border-radius: 8px;
                    overflow: hidden;
                    }

                    @keyframes slideIn {
                    from {
                    transform: translateY(20px);
                    opacity: 0;
                    }
                    to {
                    transform: translateY(0);
                    opacity: 1;
                    }
                    }

                    /* Canvi de color amb hover */
                    tbody tr:hover {
                    background-color: #e9ecef;
                    transition: background-color 0.3s ease;
                    }

                    thead th {
                    background-color: #007bff;
                    color: white;
                    text-align: center;
                    padding: 15px;
                    font-size: 18px;
                    }

                    tbody td {
                    text-align: center;
                    padding: 12px;
                    font-size: 16px;
                    }

                    h1 {
                    font-size: 2.5rem;
                    text-align: center;
                    color: #343a40;
                    animation: fadeInTitle 1s ease-in-out;
                    }

                    @keyframes fadeInTitle {
                    from {
                    opacity: 0;
                    transform: translateY(-20px);
                    }
                    to {
                    opacity: 1;
                    transform: translateY(0);
                    }
                    }

                </style>
            </head>
            <body>
                <div class="container text-center">
                    <h1 class="mt-4">Llista d'alumnes</h1>
                    <table class="table table-hover table-bordered table-striped mx-auto">
                        <thead>
                            <tr>
                                <th>Nom</th>
                                <th>Edat</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!-- Bucle per cada alumne -->
                            <xsl:for-each select="studentslist/student">
                                <tr>
                                    <td><xsl:value-of select="@name"/></td>
                                    <td><xsl:value-of select="@age"/></td>
                                </tr>
                            </xsl:for-each>
                        </tbody>
                    </table>
                </div>
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-qNUQj7zMm2mEw5ts0XZAKcsPoEf2N+ov3NjyH2bmoGkrLL0ZCqppup32feSpNVSq" crossorigin="anonymous"/>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
