/**
 * Default class description.
 *
 * @author P.Sinitsky
 * @version 1.0
 * @date 14.04.2016
 */

services
    .factory('authService', ['$cookies', '$injector', function ($cookies, $injector) {

        var appAuthInfo = btoa("givebook:laralara*GiveBook*123");
        var authUri = '/login';
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
                    $cookies.put('access_token', data.data.access_token);
                    var expireDate = new Date();
                    expireDate.setDate(expireDate.getDate() + 1000);
                    $cookies.put('refresh_token', data.data.refresh_token, {'expires': expireDate});
                    window.location.href = "#/offers";
                });
            },

            refresh: function() {
                if ($cookies.get('refresh_token') !== undefined) {
                    var $http = $injector.get("$http");
                    var req = {
                        method: 'POST',
                        url: serverUrl + authUri,
                        headers: {
                            "Authorization": "Basic " + appAuthInfo,
                            "Content-type": "application/x-www-form-urlencoded; charset=utf-8"
                        },
                        data: getRequestBodyForRefresh($cookies.get('refresh_token'))
                    };
                    $http(req).then(function (data) {
                        $cookies.put('access_token', data.data.access_token);
                        var expireDate = new Date();
                        expireDate.setDate(expireDate.getDate() + 1000);
                        $cookies.put('refresh_token', data.data.refresh_token, {'expires': expireDate});
                        window.location.reload();
                    });
                }
            },

            logOut: function () {
                $cookies.remove('access_token');
                $cookies.remove('refresh_token');
                window.location.href = "#/offers";
            }
        }
    }]);