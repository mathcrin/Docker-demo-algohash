# Projet d'exemple d'utilisation de docker 
## Description
Ce projet est un exemple d'utilisation de docker pour déployer une application spring boot avec une base de données h2.
Il ne sert que de démonstration d'utilisation de docker et n'est pas destiné à être utilisé en production.\
Nous avons une application spring boot qui permet de hasher une chaine de caractère avec différent algorithme de hashage (SHA-256, SHA-512, SHA-1, MD5) et de stocker les hash dans une base de données h2.

## URL pour accéder aux différentres fonctions de l'applications 
### Fonction de hashage
    http://localhost:8080/algoHash?input=HelloWorld&algorithm=SHA-256

- input : la chaine de caractère à hasher
- algorithm : l'algorithme de hashage à utiliser (optionnel de base c'est SHA-256) (SHA-256, SHA-512, SHA-1, MD5)
- output : le hash de la chaine de caractère

### Voir la base de données
    http://localhost:8080/algoHash/all

## Comment build l'application
1. Installer docker sur votre machine
2. Cloner le projet
3. `docker build -t demo-docker .`
4. `docker run -p 8080:8080 demo-docker`

## Comment déployer l'application
### Sans docker-compose
1. Installer docker sur votre machine
2. `docker volume create data`
3. `docker run -v data:/data -p 8080:8080 mathcrin/algohash`

### Avec docker-compose
1. Installer docker et docker-compose sur votre machine
2. récupérer le fichier [docker-compose.yml](docker-compose.yml)
3. `docker-compose up`


