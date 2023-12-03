<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/Tariffs">
        <html>
            <head>
                <title>Tariffs</title>
            </head>
            <body>
                <h2>Tariff Information</h2>
                <table border="1">
                    <tr>
                        <th>Name</th>
                        <th>Operator</th>
                        <th>Payroll</th>
                    </tr>
                    <xsl:for-each select="Tariff">
                        <tr>
                            <td><xsl:value-of select="Name"/></td>
                            <td><xsl:value-of select="OperatorName"/></td>
                            <td><xsl:value-of select="Payroll"/></td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>
