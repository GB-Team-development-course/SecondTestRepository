angular.module('gbank-front').controller('personalController', function ($scope, $http, $location, $localStorage) {
    const contextPath = 'http://localhost:5555/core/';

    $scope.loadAccounts = function () {
        $http({
            url: contextPath + 'api/v1/account/',
            method: 'GET',
        }).then(function (response) {
            console.log(response.data)
            $scope.AccountsPage = response.data;
        });
    };

    $scope.loadAccounts();
});