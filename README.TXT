------------------------------------------------------------------------
This is the project README file. Here, you should describe your project.
Tell the reader (someone who does not know anything about this project)
all he/she needs to know. The comments should usually include at least:
------------------------------------------------------------------------

PROJECT TITLE: Hangman
PURPOSE OF PROJECT: To be a fun word-based game, implemented using multiple data structures in our code.
VERSION or DATE: Nov 8, 2021
HOW TO START THIS PROJECT: Press the play/run button
AUTHORS: Conrad Mo, Aninda Saha, Johnson Zhuo Chen
USER INSTRUCTIONS: 
Hangman is a simple game in which the user tries to guess a word without letting the 
Hangman "die". Follow the prompt on the main screen to begin playing the game.
To play, press a key on your keyboard to guess a letter of the randomly generated word.
Each wrong guess will add a body part to the hangman, while each correct guess will fill up a blank.
Guessing incorrect letters 6 times will cause the hangman to be complete, causing you to lose the game.
Guessing the word correctly, no matter how many wrong guesses, results in your win!
There are also three achievements for the player to get, though they are hidden in-game.
The easy one is to guess 5 words correctly, the medium one is to guess three words correctly 
in a row, and the hard one is to guess a word correctly with no wrong guesses.

Data Structres:
ArrayList found in MyWorld (stores letters of word), Words (stores words loaded from URL)
HashMap found in MyWorld (stores letters of word with value corresponding to number of appearances in word)
