var test = require('tape');
var request = require('supertest');
//var express = require('express');

var request = require('supertest');


require = require('really-need');


//var login = require('./login');


describe('loading express', function () {
         var server;
         beforeEach(function () {
                    server = require('../server', { bustCache: true })();
                    });
         afterEach(function (done) {
                   server.server.close(done);
                   });
         it('responds to slash', function testSlash(done) {
            request(server)
            .get('/')
            .expect(200, done);
            });
         it('404 everything else', function testPath(done) {
            console.log('test 404')
            request(server)
            .get('/foo/bar')
            .expect(404, done);
            });
         });
         
