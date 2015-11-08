
var test = require('tape')
var spawn = require('tape-spawn')

var execspawn = require('npm-execspawn') // can spawn from require() scope, check it out!

// put this in outer scope so we can kill the local server at the end
var server

test('start test server', function (t) {
     // start a local http-server in the current dir (you can change path if you need to)
     server = execspawn('http-server ./ -p 54321', {pwd: __dirname})
     
     // listen for first output from server
     server.stdout.once('data', function (ch) {
                        if (ch.toString().indexOf('Starting up') > -1) t.ok(true, 'server started')
                        else t.ok(false, ch) // if it failed print out output
                        t.end()
                        })
     })

// put your tests here

test('stop server', function (t) {
     server.kill()
     t.ok(true, 'sent kill signal')
     t.end()
     })