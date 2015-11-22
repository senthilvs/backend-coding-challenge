"use strict";

/******************************************************************************************

Expenses controller

******************************************************************************************/

var app = angular.module("expenses.controller", []);

app.controller("ctrlExpenses", ["$rootScope", "$scope", "Restangular", function ExpensesCtrl($rootScope, $scope, $Restangular) {
	// Update the headings
	$rootScope.mainTitle = "Expenses";
	$rootScope.mainHeading = "Expenses";
	
	// Update the tab sections
	$rootScope.selectTabSection("expenses", 0);
	
	$scope.current_vat = 0;
	
	$scope.dateOptions = {
		changeMonth: true,
		changeYear: true,
		dateFormat: "dd/mm/yy"
	};
	
	$scope.changeAmt = function(){		
		$scope.current_vat = $scope.newExpense.amount * 0.2 ;
	}

	var loadExpenses = function() {
		// Retrieve a list of expenses via REST
		$Restangular.one("expenses").getList().then(function(expenses) {
			$scope.expenses = expenses;
		});
	}

	$scope.saveExpense = function() {
		if ($scope.expensesform.$valid) {
			// Post the expense via REST
			console.log($scope.newExpense);
			
			var data = {};
			data['amount'] = $scope.newExpense['amount'];
			data['reason'] = $scope.newExpense['reason'];
			
			var date = $scope.newExpense['date']
			
			var year = date.getFullYear();
			var month = (1 + date.getMonth()).toString();
			month = month.length > 1 ? month : '0' + month;
			var day = date.getDate().toString();
			day = day.length > 1 ? day : '0' + day;
			 
			
			data['date'] = day +'/'+ month+ '/'+ year;
			
			console.log(data);
			
			$Restangular.one("expenses").post(null, data).then(function() {
				// Reload new expenses list
				loadExpenses();
			});
		}
	};

	$scope.clearExpense = function() {
		$scope.newExpense = {};
		$scope.current_vat = 0;
	};

	// Initialise scope variables
	loadExpenses();
	$scope.clearExpense();
}]);
