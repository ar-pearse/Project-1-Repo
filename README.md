# Amatuer Photoshop Reimbursement System
 <br>
This application handles user reimbursement requests.  Employees are able to request reimbursements for expenses incurred on their time working.  They can also view all of their past requests, and even cancel a request that has yet to be resolved  The Finance Manager can then log in and either accept or deny these requests as well as sort by Employee.
<br>

# Technologies
Git, CSS, HTML, JavaScript, Java, Servlet, Tomcat, RDS, EC2
<br>

# Features
<br>
Current Features:
<ul>
 <li>Create a new reimbursement request</li>
 <li>Cancel pending reimbursement requests</li>
 <li>Accept/Reject pending reimbursement requests</li>
 <li>Sort requests by user</li>
</ul>
TODO:
<ul>
 <li>Show all accepted/rejected/pending requests to the Finance Managers</li>
 <li>Sort by requests status</li>
 <li>Further improve the UI</li>
</ul>

# Getting Started
git clone https://github.com/ar-pearse/Project-1-Repo/.git<br>
Install Tomcat and Maven onto EC2<br>
Install Jenkins onto EC2, create a job using the repository and set the build instructions as: mvn clean package<br>
Run ./start.sh in the bin of Tomcat on the EC2<br>

# Usage
Program is pretty self explanatory, login credentials are as follows:<br>
Employee:<br>
andrew.roy.pearse@gmail.com<br>
password<br>
<br>
Finance Manager:<br>
jlawn@gmail.com<br>
longgone<br>
