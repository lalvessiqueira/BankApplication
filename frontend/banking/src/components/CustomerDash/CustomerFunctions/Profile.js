import React, {Component} from 'react';
import {MDBBtn, MDBInput} from "mdb-react-ui-kit";
import './Profile.css';
import axios from "axios";



class Profile extends Component {
    constructor(props) {
        super(props);
        this.state = {
            username: window.localStorage.getItem("username"),
            fullName: "",
            customerId: "",
            phone: "",
            secretQuestion: "",
            secretAnswer: "",
            stateID: "",
            ssn: ""
        };
    }

    componentDidMount() {
        const id = localStorage.getItem("id");
        const jsonId = { id: id };
        axios.get("http://localhost:8081/api/customer/username/" + this.state.username)
            .then((response) => {
                this.setState({customerId: response.data.customerId});
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
        axios.post('http://localhost:8081/api/customer/' + this.state.customerId, this.state).then(response => {
            console.log(response.data)
            window.localStorage.setItem("username",this.state.username)
            window.location =  "/createAccount"
        }).catch(error => {
            console.log(error)
            // window.location =  "/infoMismatch"
        })
    }

    render() {
        return (
            <div className='container rounded-3' id='bg-glass'>
                <form onSubmit={this.submitHandler} className='py-2'>
                    <MDBInput className='mb-4' style={{color: 'black'}}
                        label="Customer ID"
                        placeholder={this.state.customerId}
                        readonly

                    />
                    <MDBInput className='mb-4'
                              type='text'
                              label='Full Name'
                              name="fullName"
                              value={this.state.fullName}
                              onChange={this.changeHandler}
                    />
                    <MDBInput className='mb-4'
                              type='text'
                              label='Phone #'
                              name="phone"
                              value={this.state.phone}
                              onChange={this.changeHandler}
                    />
                    <MDBInput className='mb-4'
                              type='text'
                              label='Social Security #'
                              name="ssn"
                              value={this.state.ssn}
                              onChange={this.changeHandler}
                    />
                    <MDBInput className='mb-4'
                              type='text'
                              label='stateID'
                              name="stateID"
                              value={this.state.stateID}
                              onChange={this.changeHandler}
                    />
                    <select
                        className="form-select mb-4"
                        aria-label="Security Questions"
                        name="secretQuestion"
                        onChange={this.changeHandler}>
                        <option selected>Select Security Question</option>
                        <option value="Favorite Actor / Actress">Favorite Actor / Actress</option>
                        <option value="Name of first pet">Name of first pet</option>
                        <option value="Mother's Maiden Name">Mother's Maiden Name</option>
                    </select>
                    <MDBInput className='mb-4'
                              type='text'
                              label='Enter Answer'
                              onChange={this.changeHandler}
                              name="secretAnswer"
                              value={this.state.secretAnswer}
                    />
                    <MDBBtn type='submit' className='mb-4'>
                        Update
                    </MDBBtn>
                </form>
            </div>
        );
    }
}

export default Profile;