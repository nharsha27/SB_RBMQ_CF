Docker command to start mysql

docker run -d --name mysql_nishith -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=root mysql:latest

here 
--name is the container name which you want to give to start the docker

other commands

docker images --> This will give you all the images

docker ps --> this will give you process if which is started
