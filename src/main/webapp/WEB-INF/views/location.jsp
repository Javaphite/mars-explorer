<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
   <head>
        <title> Mars explorer </title>

        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="/styles/text.css">
        <link rel="stylesheet" type="text/css" href="/styles/${colorSchema}.css">
   </head>

   <body>
      <h1> Location </h1>
      <div class="grid-container">
        <div class="grid-description"> ${currentLocation} </div>
        <div class="grid-details"> ${details} </div>
        <div class="grid-image">
          <img src="${image}" alt="X">
        </div>
   </body>
</html>