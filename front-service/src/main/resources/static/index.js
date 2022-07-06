(function () {
    angular
        .module('gbank-front', ['ngRoute', 'ngStorage'])
        .config(config)
        .run(run);

    function config($routeProvider) {
        $routeProvider
            .when('/', {
                templateUrl: 'welcome/welcome.html',
                controller: 'welcomeController'
            })
            .when('/personal', {
                templateUrl: 'personal/personal.html',
                controller: 'personalController'
            })
            .otherwise({
                redirectTo: '/'
            });
    }

    function run($rootScope, $http, $localStorage) {
    }
})();

angular.module('gbank-front').controller('indexController', function ($rootScope, $scope, $http, $location, $localStorage) {
});