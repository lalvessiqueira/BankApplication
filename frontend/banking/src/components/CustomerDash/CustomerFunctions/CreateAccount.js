import React, {Component} from 'react';
import {MDBBtn, MDBInput, MDBInputGroup, MDBRadio} from "mdb-react-ui-kit";

class CreateAccount extends Component {
    render() {
        return (
            <div>
                <div className='container rounded-3 d-flex justify-content-center' id='bg-glass'>
                    <form className='py-2'>
                        <p className='text-uppercase fw-bold fs-4'>Create Account</p>
                        <MDBInputGroup textBefore='$' className='mb-4 d-flex'>
                            <input
                                type='text'
                                className='form-control'
                                placeholder='Enter Initial Deposit'
                                required
                            />
                        </MDBInputGroup>

                        <p>Select Account Type:</p>
                        <div className='d-flex justify-content-evenly mb-3 btn-outline-white rounded-pill'>
                            <MDBRadio name='accountRadio' label='Checking' defaultChecked/>
                            <MDBRadio name='accountRadio' label='Savings '/>
                        </div>

                        <MDBBtn type='submit' className='mb-4'>
                            Update
                        </MDBBtn>
                    </form>
                </div>
            </div>
        );
    }
}

export default CreateAccount;