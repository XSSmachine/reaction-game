# reaction-game
Java GUI program with few reaction games

The idea of the program is that user can register(creates a folder with the name of folder being the users username and password) and then login with his credentials(creates 4 csv files in their folder). 

Then after the successful login, the user will be displayed a menu which has 6 JButtons(one for each of 4 games, statistics and logout button). When the user clicks on the game1 button, it leads the user to the description page(i was thinking about implementing own class/jpanel/card but the problem i faced is that i already passed Firstframe argument into all the other class constructors, i dont know a way to pass info for the description class to choose between 4 different descriptions to display) and on there also it will be a start button*. 

Then after u press start there will be another jpanel shown which is going to display a button with 5 seconds delay and the user is asked to press on it as soon as its displayed and then he gets the time displayed on ScoreScreen class/jpanel which should also have 2 buttons(one to play again and one to get back to menu), i would also like to put on the leaderboard feature when u can see how u stand against other player top scores + i want to write each time in game corresponding csv file. 

The same would be applied for all other 3 games. Then in statistics i wanna make a 4 tab panel which i can choose between each game and display avrg, best and worst time for each game and have an option to see the table representation of the csv file.
There user could see all the times of the games played cronologically(1,2,3,4...).

The problem im having rn is how to restart a game without the score resault pilling on the jpanel of scorescreen class and how to clear the game1 jpanel every time user wants to play again.
