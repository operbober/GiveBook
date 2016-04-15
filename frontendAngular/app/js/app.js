/**
 * Default class description.
 *
 * @author P.Sinitsky
 * @version 1.0
 * @date 21.03.2016
 */
'use strict';

var app = angular.module('giveBook', ['ngRoute', 'ngCookies', 'giveBook.services', 'giveBook.directives']);
var services = angular.module('giveBook.services', []);
var directives = angular.module('giveBook.directives', []);

app.config(['$routeProvider', '$httpProvider', function ($routeProvider, $httpProvider) {

    $routeProvider
        .when('/login', {
            templateUrl: '../layout/security/login.html',
            controller: 'loginController',
            uri: '/login/'
        })
        .when('/offers', {
            templateUrl: '../layout/offer/offer.html',
            controller: 'offerController',
            uri: '/offers/'
        })
        .when('/offerTypes', {
            templateUrl: '../layout/template/dictionaryTable.html',
            controller: 'dictionaryController',
            uri: '/offerTypes/'
        })
        .when('/bookTypes', {
            templateUrl: '../layout/template/dictionaryTable.html',
            controller: 'dictionaryController',
            uri: '/bookTypes/'
        })
        .when('/bookConditions', {
            templateUrl: '../layout/template/dictionaryTable.html',
            controller: 'dictionaryController',
            uri: '/bookConditions/'
        })
        .when('/genres', {
            templateUrl: '../layout/template/dictionaryTable.html',
            controller: 'dictionaryController',
            uri: '/genres/'
        });

    $httpProvider.interceptors.push('authInjector');
}]);