# Systeme_bancaire
 
Présentation : <br/><br/>

Dans cet exercice, nous allons modéliser un système bancaire dans lequel
des clients pourront ouvrir ou clôturer des comptes qu'ils soient individuels
ou conjoints (partagé par 2 personnes). Sur chaque compte, un client
pourra créditer de l'argent (déposer) ou en débiter (retirer) voir réaliser des transferts d'un compte à un autre. <br/>

Question : <br/>

1. Représenter sous forme de diagramme de classe ce problème <br/><br/>

![diagramme de classe 3.1](assets/diagramme_de_classe_systeme_bancaire.drawio.svg)

2. Coder les différentes fonctionnalités en utilisant de la POO <br/><br/>
Faites attention aux arnaques potentielles <br/><br/>

3. Dans votre main réaliser un jeu de test permettant de valider vos
différentes fonctionnalités. Pour rappel, un jeu de test ne doit pas
permettre à l'utilisateur de tester votre programme mais plutôt
montrer les différents cas que vous avez vous même testé. Pour
réaliser cela, vous êtes libre d'utiliser une technologie comme JUNIT
ou de les faire à la main dans votre main. Chaque test doit avoir un
commentaire précisant le cas à tester (cas normal ou particulier),
exécuter les méthodes nécessaires et afficher les résultats obtenus en
console. <br/>

Exemple de test : <br/>

Test de la fonction créditer <br/>

* Création d'un compte <br/><br/>
* Affichage du solde <br/><br/>
* Affichage d'un message expliquant le test <br/><br/>
* Appel de la méthode créditer <br/><br/>
* Affichage du solde du compte <br/>

Code du test (réalisé à la main dans le main) : <br/>

<span style="color:green">// Test de la méthode créditer (Cas normal)</span>

> Compte compteTest = new Compte("TOTO"); <br/>
> System.out.printf("Solde actuel %f", compteTest.getSolde()); <br/>
> System.out.printf("Ajout de 50€ sur le compte TOTO"); <br/>
> compteTest.crediter(50); <br/>
> System.out.printf("Solde actuel %f", compteTest.getSolde());

