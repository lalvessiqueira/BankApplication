import React, {Component} from 'react';
import {MDBBtn, MDBInput, MDBRadio} from "mdb-react-ui-kit";
import axios from "axios";

class AddBeneficiary extends Component {
    constructor(props) {
        super(props);
        this.state = {
            username: window.localStorage.getItem("username"),
            customerId: "",
            accountType: "CHECKING_ACCOUNT",
            beneficiaryAcctNo: "",
            confirmBeneficiaryAcctNo: "",
            beneficiaryName: ""
        };
    }

    componentDidMount() {
        axios.get("http://localhost:8081/api/customer/username/" + this.state.username)
            .then((response) => {
                this.setState({customerId: response.data.customerId});
                console.log(this.state)
            })
            .catch((error) => {
                console.log(this.state)
                console.log(error)
            });
    }

    changeHandler = e => {
        this.setState({[e.target.name]: e.target.value})
    }

    submitHandler = e => {
        if (this.state.beneficiaryAcctNo === this.state.confirmBeneficiaryAcctNo) {
            e.preventDefault()
            console.log("this.state:")
            console.log(this.state)
            axios.post('http://localhost:8081/api/customer/' + this.state.customerId + "/beneficiary", this.state).then(response => {
                console.log(response.data)
            }).catch(error => {
                console.log(error)
            })
        } else {
            e.preventDefault()
            alert("Account numbers don't match!")
        }
    }

    render() {
        return (
            <div className='container rounded-3 mb-3 d-flex justify-content-center' id='bg-glass'>
                <form onSubmit={this.submitHandler} className='py-3'>
                    <MDBInput className='mb-4'
                              type='text'
                              label='Enter Full Name'
                              name="beneficiaryName"
                              value={this.state.beneficiaryName}
                              onChange={this.changeHandler}/>
                    <MDBInput className='mb-4'
                              type='text'
                              label='Enter Account Number'
                              name="beneficiaryAcctNo"
                              value={this.state.beneficiaryAcctNo}
                              onChange={this.changeHandler}/>
                    <MDBInput className='mb-4'
                              type='text'
                              label='Confirm Account'
                              required
                              name="confirmBeneficiaryAcctNo"
                              value={this.state.confirmBeneficiaryAcctNo}
                              onChange={this.changeHandler}
                    />

                    <p>Select Account Type:</p>
                    <div className='d-flex justify-content-evenly mb-3 btn-outline-white rounded-pill'>

                        <MDBRadio name='accountType'
                                  label='Checking'
                                  defaultChecked
                                  value="CHECKING_ACCOUNT"
                                  onChange={this.changeHandler}/>&nbsp;&nbsp;
                        <MDBRadio name='accountType'
                                  label='Savings'
                                  value="SAVINGS_ACCOUNT"
                                  onChange={this.changeHandler}/>
                    </div>

                    <MDBBtn type='submit' className='my-2'>
                        Add Beneficiary
                    </MDBBtn>
                </form>
            </div>
        );
    }
}

export default AddBeneficiary;