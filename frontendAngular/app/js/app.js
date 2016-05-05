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

app
    .config(['$routeProvider', '$httpProvider', function ($routeProvider, $httpProvider) {

        $routeProvider
            .when('/login', {
                templateUrl: '../layout/security/login.html',
                controller: 'loginController',
                uri: '/login/'
            })
            .when('/register', {
                templateUrl: '../layout/security/register.html',
                controller: 'loginController',
                uri: '/register/'
            })
            .when('/offers', {
                templateUrl: '../layout/offer/offer.html',
                controller: 'offerController',
                uri: '/offers/'
            })
            .when('/myOffers', {
                templateUrl: '../layout/offer/offer.html',
                controller: 'offerController',
                uri: '/myOffers/',
                requires: {login: true}
            })
            .when('/offerTypes', {
                templateUrl: '../layout/template/dictionaryTable.html',
                controller: 'dictionaryController',
                uri: '/offerTypes/'
            })
            .when('/bookTypes', {
                templateUrl: '../layout/template/dictionaryTable.html',
                controller: 'dictionaryController',
                uri: '/bookTypes/',
                requires: {login: true, role: 'ROLE_ADMIN'}
            })
            .when('/bookConditions', {
                templateUrl: '../layout/template/dictionaryTable.html',
                controller: 'dictionaryController',
                uri: '/bookConditions/',
                requires: {login: true, role: 'ROLE_ADMIN'}
            })
            .when('/genres', {
                templateUrl: '../layout/template/dictionaryTable.html',
                controller: 'dictionaryController',
                uri: '/genres/',
                requires: {login: true, role: 'ROLE_ADMIN'}
            })
            .when('/404', {
                templateUrl: '../layout/security/404.html'
            })
            .when('//:code', {
                templateUrl: '../layout/offer/offer.html',
                controller: 'offerController',
                uri: '/offers/'
            })
            .otherwise({
                redirectTo: '/404'
            });

        $httpProvider.interceptors.push('authInjector');
    }])

    .run(['$rootScope', '$location', 'securityService', function ($rootScope, $location, securityService) {

        $rootScope.$on("$routeChangeStart", function (event, next) {
            if (next.requires && next.requires.login) {
                if (!securityService.isAuthenticated()) {
                    $location.path('/login');
                }
                if (next.requires.role && !securityService.hasRole(next.requires.role)) {
                    $location.path('/404');
                }
            }
        });
    }]);