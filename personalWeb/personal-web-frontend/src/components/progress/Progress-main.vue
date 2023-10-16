<script setup>

</script>

<template>
  <article class="main-content-page">
    <section id="intro">
      <h1>
        My first App
      </h1>
      <div class = "main-intro">
        <p>
          This is an App based on the AppLab on the <a href="https://www.code.org">code.org </a>.
          It has a lot of special techniques that I create for functional reason, like
          a "fake class".
        </p>
        <p>
          Can you play it? I do think it is a small stupid game...
        </p>
      </div>
      <!--        <div>-->
      <!--          <iframe id="app-view" src="../CardsMemoryGame/game.html">-->
      <!--          </iframe>-->
      <!--          <button class = "iframe-button" onclick="refreshFrame();">-->
      <!--          </button>-->
      <!--        </div>-->
    </section>

    <section id="fakeClass">
      <h1>
        Fake Class
      </h1>
      <div aria-labelledby = "fakeClass">
        <p>
          Initially, I did not have any concept of a <a herf="" style="color: orange">Class</a>. These
          dictionaries named card1, card2, card3... behave just like real cards because they have properties
          such as "isMatched" and "isFaceUp". These properties are composed within each card,
          allowing the game to continue. At the time, it was the best way for me to handle the matching and
          state changes of each card.
        </p>
      </div>
      <!--        <picture>-->
      <!--          <img src="./img/Fake%20Class.png " >-->
      <!--          <div class = "picture-description" >The original code of "Fake class"</div>-->
      <!--        </picture>-->
      <div>
        <p>
          After I learned java, the real Class showed me that what I did is stupid... hhhh
        </p>
      </div>
    </section>
    <section id = "gameLogic">
      <h1>
        Game Logic
      </h1>
      <div>
        <p>
          With this "Fake Class," the logic of the game becomes very simple. I prepared a list to store the
          cards clicked by the user and then compared the "CardContent" of the two cards. Finally, based on
          the comparison result, I determined whether to flip (change the color)
        </p>
      </div>
      <!--        <picture>-->
      <!--          <img src="./img/GameLogic.png">-->
      <!--          <div class = "picture-description" >A part of "logic methods"</div>-->
      <!--        </picture>-->
      <div>
        <p>
          The "updateGame" method is responsible for initializing all default cards in the game. It assigns
          the card content and card number (position on the canvas) to each card.
        </p>
      </div>
      <!--        <picture>-->
      <!--          <img src="./img/updateGameMethod.png">-->
      <!--          <div class = "picture-description">The "updateGame" method</div>-->
      <!--        </picture>-->
      <div>
        <p>
          The "flipCard" method is responsible for changing the state of cards. It changes the color and
          size of the card, and make the bool property "clickable" into false.
        </p>
      </div>
      <!--        <picture>-->
      <!--          <img src="./img/FlipCardmethod.png">-->
      <!--          <div class = "picture-description">-->
      <!--            The "flipCard" method-->
      <!--          </div>-->
      <!--        </picture>-->
    </section>
    <div class = "blank">
    </div>
    <section id = "intro2">
      <h1>
        My first Java program: Dictionary
      </h1>
      <div>
        <p>
          Thanks to the Computer Science: Application, an Advance Placement curriculum, I had my first experience on
          Java language. After studied Array, Arraylist, 2D Array and Class, a program responsible for translating English phrases
          into Chinese had been build.
        </p>
      </div>
      <!--        <div class = "link-container">-->
      <!--          <img  src = "./img/github.png">-->
      <!--          <div class = "link-style">-->
      <!--            <a class = "text-underline" href="https://github.com/EdwinZhanCN/CSAcodes" style="color: #293541" target="_blank">See the whole program in my GitHub repository "CSAcodes"</a>-->
      <!--            <div class = "svg-container">-->
      <!--              <svg  xmlns="http://www.w3.org/2000/svg" height="1em" viewBox="0 0 448 512">&lt;!&ndash;! Font Awesome Free 6.4.0 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License) Copyright 2023 Fonticons, Inc. &ndash;&gt;<path d="M438.6 278.6c12.5-12.5 12.5-32.8 0-45.3l-160-160c-12.5-12.5-32.8-12.5-45.3 0s-12.5 32.8 0 45.3L338.8 224 32 224c-17.7 0-32 14.3-32 32s14.3 32 32 32l306.7 0L233.4 393.4c-12.5 12.5-12.5 32.8 0 45.3s32.8 12.5 45.3 0l160-160z"/></svg>-->
      <!--            </div>-->
      <!--          </div>-->
      <!--        </div>-->
    </section>
    <div class = "blank">

    </div>
    <section id = "bisearch">
      <h1>
        Binary Search
      </h1>
      <div>
        <p>
          Binary search is an algorithm for finding an element in a sorted array. To convert the phrase into "numbers", I use the
          ASCII code of capital letter as the reference, when it finds the same ASCII code with the target phrase like "apple" and "abandon",
          it will stop binary searching and change into a linear search, then find the final phrase.
        </p>
      </div>
    </section>
    <section id = "dataSelect">
      <h1>
        Data selection
      </h1>
    </section>
    <section id = "userInter">
      <h1>
        User Interaction
      </h1>
    </section>
  </article>
</template>

<style scoped>
*{
  margin: 0;
}

h1{
  font-family: Arial, Helvetica, sans-serif;
  font-size: 45px;
  font-weight: 500;
  margin-inline-start: 0;
  margin-inline-end: 0;
}



.main-intro{
  margin-top: 20px;
}

p{
  border-radius: 10px;
  background-color: rgba(187, 221, 185, 0.275);
  font-family: Arial, Helvetica, sans-serif;
  line-height: 2em;
}
</style>