var Bookshelf = require('bookshelf');

var config = {
host: '107.180.50.210',  // your host
user: 'Testers', // your database user
password: 'Theend2', // your database password
database: 'BonisTest',
charset: 'UTF8_GENERAL_CI'
};

var DB = Bookshelf.initialize({
                              client: 'mysql',
                              connection: config
                              });

module.exports.DB = DB;