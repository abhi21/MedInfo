jQuery(document).ready(function () {

    $("#HCProviderCommand").validate({
        rules: {
            name: {
                required: true
            },
            role: {
                required: true
            },
            phone: {
                required: true
            },
            pincode: {
                required: true
            },
            state: {
                required: true
            },
            city: {
                required: true
            }
        },
        messages: {
            name: {
                required: "Please enter the name"
            },
            role: {
                required: "Please enter the role"
            },
            phone: {
                required: "Please select the phone number"
            },
            pincode: {
                required: "Please select the pincode"
            },
            state: {
                required: "Please select the state"
            },
            city: {
                required: "Please select the city"
            }
        }
    });
});

document.observe('dom:loaded', function () {
    RowSelector.bindEvents();
});

