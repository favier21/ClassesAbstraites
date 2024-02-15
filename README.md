Le ficher sources.txt est utilisé pour compiler les 3 package ainsi que le main.

La class exécutable est appelé main qui se trouve dans:
src/games/main.java

Mode d'emploi du lancement du code:
Pour compiler ecrivez: 
javac -d build -cp @sources.txt


Le jeu de Nim et le TicTacToe peuvent tout les deux être lancé dans le main. 

Pour lancer le jeu de Nim ou le TicTacToe il faut écrire: 

java -cp build games.genericgames.Main

Lorque la class est lancée elle vous demande les types des deux joueurs.

En effet il y a plusieurs type de joueurs, vous pouvez affronter un autre joueur
ou encore vous pouvez faire se battre une IA random avec NegaMaxPlayers (qui est une IA intelligente).
Donc pour choisir le type de joueur il suffit d'écrire l'un des types de joueur dans la liste des types disponibles

Ensuite vous pouvez entrer le jeu auquel vous souhaitez jouer.

Il suffit d'écrire le nom d'un des jeux dans la liste.



Pour la réponse à la question exercice 6.6: On constate qu'a partir du moment ou il reste 13 batons et que c'est à nous de jouer nous sommes sur de perdre contre Negamax. On constate donc que Negamax va nous faire arriver au nombre 13 pour forcément gagner.
