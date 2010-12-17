sudo rm -R /root/.m2
sudo ln -s /home/domdorn/.m2 /root/.m2
sudo mvn exec:java -Dexec.mainClass=MailServer -o
