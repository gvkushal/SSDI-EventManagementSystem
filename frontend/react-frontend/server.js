var express = require("express");
const bodyParser = require("body-parser");
const cors = require('cors');
var app = express();
app.use(cors());
app.options('*', cors());
app.use(express.json());
app.use(express.urlencoded({ extended: true }));

//for get call
app.get("/", (req, res, next) => {
    res.json(["TEST"]);
   })


//POST call sign -up-process
// app.post('/sign-up-process', function (req, res) {  
//     response = {  
//         firstname:req.body.firstname,
//         lastname: req.body.lastname,
//         email:req.body.email,
//         password:req.body.password
//     };  
//     console.log(response);  
//     res.end(JSON.stringify(response));  
//  })  

app.listen(3000, () => {
 console.log("Server running on port  http://localhost:3000");
});