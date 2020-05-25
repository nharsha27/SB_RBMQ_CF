
Git basic command
git init
git add all
git add *
git ls
git status
git commit -m "initial commit"
git add origin https://github.com/nharsha27/SB_RBMQ_CF.git
git remote add origin https://github.com/nharsha27/SB_RBMQ_CF.git
git push -f *
git -f push
git push
  181  git push origin master
  182  git -f push origin master
  183  git push -f origin master


Basic docker commands
Docker images --> Will give you list of all the images your docker has

docker ps ==> once you start any process, one pid will be generated and that pid will be shown in this commnad

docker kill pid --> to kill any process


To Stat MYSQL in Docker
docker run -d --name mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=root mysql:5

To Start Rabbit MQ in docker
docker run -d --name rabbitmq -p 15672:15672 -p 5672:5672 --name testingrabbitmq rabbitmq:3-management

URL for Rabbit MQ, please make sure to enable management plugin to view the GUI
http://192.168.99.100:15672/#/
