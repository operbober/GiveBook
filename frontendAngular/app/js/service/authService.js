/**
 * Default class description.
 *
 * @author P.Sinitsky
 * @version 1.0
 * @date 14.04.2016
 */

services
    .factory('authService', ['$injector', function ($injector) {

        var appAuthInfo = btoa("givebook:laralara*GiveBook*123");
        var authUri = '/login';
        var registerUri = '/register';
        var getRequestBodyForAuth = function (login, password) {

            return 'grant_type=' + 'password'
                + '&username=' + login
                + '&password=' + password;
        };
        var getRequestBodyForRefresh = function (refreshToken) {

            return 'grant_type=' + 'refresh_token'
                + '&refresh_token=' + refreshToken;
        };

        return {
            logIn: function (login, password) {
                var $http = $injector.get("$http");
                var req = {
                    method: 'POST',
                    url: serverUrl + authUri,
                    headers: {
                        "Authorization": "Basic " + appAuthInfo,
                        "Content-type": "application/x-www-form-urlencoded; charset=utf-8"
                    },
                    data: getRequestBodyForAuth(login, password)
                };
                $http(req).then(function (data) {
                    sessionStorage.setItem('access_token', data.data.access_token);
                    sessionStorage.setItem('refresh_token', data.data.refresh_token);
                    sessionStorage.setItem('authorities', JSON.stringify(data.data.authorities));
                    window.location.href = "#/offers";
                });
            },

            refresh: function() {
                if (sessionStorage.getItem('refresh_token') !== null) {
                    var $http = $injector.get("$http");
                    var req = {
                        method: 'POST',
                        url: serverUrl + authUri,
                        headers: {
                            "Authorization": "Basic " + appAuthInfo,
                            "Content-type": "application/x-www-form-urlencoded; charset=utf-8"
                        },
                        data: getRequestBodyForRefresh(sessionStorage.getItem('refresh_token'))
                    };
                    $http(req).then(function (data) {
                        sessionStorage.setItem('access_token', data.data.access_token);
                        sessionStorage.setItem('refresh_token', data.data.refresh_token);
                        sessionStorage.setItem('authorities', JSON.stringify(data.data.authorities));
                        window.location.reload();
                    });
                }
            },

            logOut: function () {
                sessionStorage.removeItem('access_token');
                sessionStorage.removeItem('refresh_token');
                sessionStorage.removeItem('authorities');
                window.location.href = "#/offers";
            },

            register: function(login, email, password) {
                var $http = $injector.get("$http");
                $http.put(serverUrl + registerUri, {login: login, email: email, password: password}).then(function (data) {
                    window.location.href = "#/login";
                });
            }
        }
    }]);