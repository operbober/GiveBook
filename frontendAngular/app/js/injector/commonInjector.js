/**
 * Default class description.
 *
 * @author P.Sinitsky
 * @version 1.0
 * @date 15.04.2016
 */
services
    .factory('commonInjector', function() {

        return {
            request: function (config) {
                config.headers['Content-Type'] = ['application/json'];
                return config;
            }
        };
    });