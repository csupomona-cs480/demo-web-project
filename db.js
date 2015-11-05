var Bookshelf = require('bookshelf');

var config = {
host: 'bonisusers.cuxilwg0ru3n.us-west-2.rds.amazonaws.com',  // your host
user: 'AwesomeTeam', // your database user
port: '3306',
password: 'ThePass2', // your database password
database: 'dbUsers',
charset: 'UTF8_GENERAL_CI'
};

var DB = Bookshelf.initialize({
                              client: 'mysql',
                              connection: config
                              });

module.exports.DB = DB;