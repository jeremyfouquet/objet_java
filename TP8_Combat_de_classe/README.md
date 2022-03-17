# combat_de_classe

Principe de base :<br/><br/>

Nous allons coder un autre petit jeu impliquant 2 joueurs (IA / Player).
Ce jeu utilisera 3 types de personnages différents : Archer, Cavalier et
Soldat en armure. Chaque personnage aura 5 points de vie, 1 point
d'attaque et pourra accomplir 3 types d'actions :<br/><br/>

• Attaquer (qui permettra d'infliger x dégâts à l'adversaire, dégâts
calculer en fonction des points d'attaques)<br/><br/>
• Se protéger (ce qui annulera tout dégât)<br/><br/>
• Se soigner (action spéciale utilisable qu'une seule fois permettant de
récupérer 2 points de vie)<br/><br/>
De plus, chaque personnage aura une compétence spéciale active tout au
long du jeu:<br/><br/>

• L'archer gagnera +1 d'attaque s'il est contre un cavalier.<br/><br/>
• Le cavalier lui aura +1 contre un soldat.<br/><br/>
• Le soldat le gagnera contre un archer.<br/><br/>

Déroulement du jeu :<br/><br/>

Au début du jeu chaque player va choisir une classe sans connaître celle de
l'adversaire. Une fois les choix effectués, la partie commence. À chaque
tour, on affiche au joueur la liste de ces possibilités. Le jeu prend fin quand
un des personnages perd tous ces points de vie.<br/><br/>
Questions :<br/>

1. Représenter sous forme de diagramme de classe ce programme.<br/><br/>

![diagramme de classe 2.1](assets/diagramme_de_classe_combat_de_classe.drawio.svg)

2. Coder les classes Archer, Cavalier et Soldat, Player, IA, ainsi que la
classe principale Jeu.<br/><br/>

3. Coder une fonctionnalité de coup critique. Un coup critique
permettra d'ignorer l'action se protéger de l'adversaire et pourra être
réalisé par chaque personnage. Par défaut, la chance de critique sera
de 25% et doublera à chaque fois que l'adversaire se protège par
contre si l'adversaire réalise une attaque, ce pourcentage redescendra
à 25% (Ce qui veut dire que si l'adversaire se protège 2 fois de suite
la chance de coup critique au 3e tour sera alors de 100%)<br/><br/>

4. Représenter sous forme de diagramme de séquence le
fonctionnement de votre code.<br/><br/>

![diagramme de sequence](assets/diagramme_de_sequence_combat_de_classe.drawio.svg)