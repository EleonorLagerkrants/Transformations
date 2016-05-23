<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
<html>
<body>
<h1>Star Wars Movies</h1>
<table border="5">
      <tr bgcolor="#6699FF">
        <th style="text-align:left">Title</th>
        <th style="text-align:left">IMDb Rank</th>
        <th style="text-align:left">Year</th>
      </tr>
      <xsl:for-each select="movies/movie">
      <tr>
        <td><xsl:value-of select="@title"/></td>
        <td><xsl:value-of select="rank"/></td>
        <td><xsl:value-of select="year"/></td>
      </tr>
      </xsl:for-each>
    </table>
  </body>
  </html>
</xsl:template>
</xsl:stylesheet>