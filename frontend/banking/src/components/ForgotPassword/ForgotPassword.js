import React, {Component} from 'react';
import {MDBBtn, MDBCheckbox, MDBCol, MDBInput, MDBRow} from "mdb-react-ui-kit";
import axios from "axios";
import {Link} from "react-router-dom";
import UpdatePassword from "./UpdatePassword";
import reportWebVitals from "../../reportWebVitals";

class ForgotPassword extends Component {
    constructor(props) {
        super(props);
        this.state = {
            username: '',
            secQuestion: '',
            answer: ''
        };
    }

    changeHandler = e => {
        this.setState({[e.target.name]: e.target.value})
    }

    clicked = e => {
        e.preventDefault()
        console.log(this.state)
    }

    afterAuthentication = () => {
        if (this.state.returnMessage === "Sorry your secret details are not matching" || this.state.returnMessage === "User name do not found") {

        }
    }

    //
    // setErrorMessage = () => {
    //     let response = this.afterAuthentication;
    // }

    submitHandler = e => {
        e.preventDefault()
        console.log("this.state:")
        console.log(this.state)
        axios.get('http://localhost:8081/api/customer/' + this.state.username + "/forgot/" + this.state.secQuestion + "/" + this.state.answer).then(response => {
            console.log(response.data)
            if (response.data === "Sorry your secret details are not matching" || response.data === "Username not found") {
                window.location =  "/infoMismatch"
            } else {
                window.localStorage.setItem("username",this.state.username)
                window.location =  "/updatePassword"
            }
        }).catch(error => {
            console.log(error)
            window.location =  "/infoMismatch"
        })
    }

    render() {
        return (
            <div className="container rounded-3" id='bg-glass'>
                <form onSubmit={this.submitHandler}>
                    <MDBRow className='mb-4'>
                        <MDBCol>
                            <MDBInput className='mt-4'
                                      label='Enter Username'
                                      name="username"
                                      value={this.state.username}
                                      onChange={this.changeHandler}
                            />
                        </MDBCol>
                    </MDBRow>

                    <MDBRow className='mb-4'>
                        <MDBCol>
                            <select
                                className="form-select"
                                aria-label="Security Questions"
                                onChange={this.changeHandler}
                                name="secQuestion">
                                <option selected>Security Questions</option>
                                <option value="Favorite Actor / Actress">Favorite Actor / Actress</option>
                                <option value="Name of first pet">Name of first pet</option>
                                <option value="Mother's Maiden Name">Mother's Maiden Name</option>
                            </select>
                        </MDBCol>
                    </MDBRow>

                    <MDBInput wrapperClass='mb-4'
                              type='text'
                              label='Enter Answer'
                              name="answer"
                              value={this.state.answer}
                              onChange={this.changeHandler}/>

                    <MDBBtn className='mb-4' type='submit'>Submit</MDBBtn>
                    <MDBRow className='mb-4'>
                        <MDBCol>
                            <p color='black'>Already have a Customer account? <a href='/'>Login here</a></p>
                        </MDBCol>
                    </MDBRow>
                </form>
            </div>
        );
    }
}

export default ForgotPassword;