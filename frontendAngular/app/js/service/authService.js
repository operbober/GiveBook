/**
 * Default class description.
 *
 * @author P.Sinitsky
 * @version 1.0
 * @date 14.04.2016
 */

services
    .factory('authService', ['$cookies', '$http', function ($cookies, $http) {

        var encoded = btoa("givebook:laralara*GiveBook*123");
        var authUri = '/login';
        var getRequestBodyForAuth = function (login, password) {

            return 'grant_type=' + 'password'
                + '&username=' + login
                + '&password=' + password;
        };

        return {
            logIn: function (login, password) {
                var req = {
                    method: 'POST',
                    url: serverUrl + authUri,
                    headers: {
                        "Authorization": "Basic " + encoded,
                        "Content-type": "application/x-www-form-urlencoded; charset=utf-8"
                    },
                    data: getRequestBodyForAuth(login, password)
                };
                $http(req).then(function (data) {
                    $cookies.put('access_token', data.data.access_token);
                    var expireDate = new Date();
                    expireDate.setDate(expireDate.getDate() + 1000);
                    $cookies.put('refresh_token', data.data.refresh_token, {'expires': expireDate});
                    window.location.href = "#/offerTypes";
                });
            },

            logOut: function () {
                $cookies.remove('access_token');
                $cookies.remove('refresh_token');
            }
        }
    }]);