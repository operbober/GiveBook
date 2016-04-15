/**
 * Default class description.
 *
 * @author P.Sinitsky
 * @version 1.0
 * @date 14.04.2016
 */
services
    .factory('authInjector', ['securityService', function(securityService) {

        return {
            request: function (config) {
                if (securityService.isAuthenticated()) {
                    config.headers['Authorization'] = securityService.getAccessToken();
                }
                return config;
            }
        };
    }]);