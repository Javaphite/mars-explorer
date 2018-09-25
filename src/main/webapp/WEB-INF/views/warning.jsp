<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
   <head>
        <title> Mars explorer: error </title>

        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="/styles/text.css">
        <link rel="stylesheet" type="text/css" href="/styles/${colorSchema}.css">
   </head>

   <body>
      <h1> Warning! </h1>
      <div class="grid-container">
        <div class="grid-description"> ${errorMessage} </div>
        <div class="grid-image">
          <img src="${image}" alt="X">
        </div>
   </body>
</html>