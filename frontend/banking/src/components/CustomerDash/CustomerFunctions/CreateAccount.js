import React, {Component} from 'react';
import {MDBBtn, MDBInput, MDBInputGroup, MDBRadio} from "mdb-react-ui-kit";
import axios from "axios";

class CreateAccount extends Component {
    constructor(props) {
        super(props);
        this.state = {
            username: window.localStorage.getItem("username"),
            customerId: "",
            accountBalance: 0.0,
            accountType: "CHECKING_ACCOUNT",
            approved: "no",
            dateOfCreation: "2022-05-24",
            accountStatus: "DISABLED"
            //no approver name
        };
    }


    componentDidMount() {
        axios.get("http://localhost:8081/api/customer/username/" + this.state.username)
            .then((response) => {
                this.setState({customerId: response.data.customerId});
                console.log(this.state)
            })
            .catch((error) => {
                console.log(error)
            });
    }

    changeHandler = e => {
        this.setState({[e.target.name]: e.target.value})
    }

    submitHandler = e => {
        e.preventDefault()
        console.log("this.state:")
        console.log(this.state)
        axios.post('http://localhost:8081/api/customer/' + this.state.customerId +"/account", this.state).then(response => {
            console.log(response.data)
        }).catch(error => {
            console.log(error)
        })
    }

    render() {
        return (
                <div className='container rounded-3 d-flex justify-content-center' id='bg-glass'>
                    <form onSubmit={this.submitHandler} className='my-4'>
                        <MDBInputGroup textBefore='$' className='mb-4'>
                            <input
                                type='text'
                                className='form-control'
                                placeholder='Enter Initial Deposit'
                                required
                                name="accountBalance"
                                value={this.state.accountBalance}
                                onChange={this.changeHandler}
                            />
                        </MDBInputGroup>

                        <p>Select Account Type:</p>
                        <div className='d-flex justify-content-evenly mb-3 btn-outline-white rounded-pill'>
                            <MDBRadio name='accountType'
                                      label='Checking'
                                      defaultChecked
                                      value="CHECKING_ACCOUNT"
                                      onChange={this.changeHandler}/>
                            <MDBRadio name='accountType'
                                      label='Savings'
                                      value="SAVINGS_ACCOUNT"
                                      onChange={this.changeHandler}/>
                        </div>

                        <MDBBtn type='submit' className='my-2'>
                            Create Account
                        </MDBBtn>
                </form>
            </div>
        );
    }
}

export default CreateAccount;