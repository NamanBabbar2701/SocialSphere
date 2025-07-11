# PreRequsite for Using this project
1. Download H2 Database Engine jar file (Download Link: https://www.h2database.com/html/cheatSheet.html)
2. Install and Extract Apache Tomcat {Zip File For Windows /tar.gz for MacOs} (Download Link: https://tomcat.apache.org/download-11.cgi)
3. Edit pom.xml and paste your apache-tomcat-11.0.8 webapps path in todir  in (Sample <target> <copy file="${project.build.directory}/${project.build.finalName}.war"
todir="C:\Users\naman\apache-tomcat-11.0.8\webapps" overwrite="true"/> </target> )
4. Edit the path in DBUtil in util folder to the path of your database (Sample  getConnection("jdbc:h2:C:/Users/naman/OneDrive/Desktop/SocialSphereDB", "sa", "");
5. DBUtil path should be same as your H2 Database path.

    
