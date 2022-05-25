import React, {Component} from 'react';
import {MDBBtn, MDBInput, MDBRadio} from "mdb-react-ui-kit";

class AddBeneficiary extends Component {
    render() {
        return (
            <div className='container rounded-3 mb-3 d-flex justify-content-center' id='bg-glass'>
                <form className='py-3'>
                    <MDBInput className='mb-4' type='text' label='Enter Account Number' />
                    <MDBInput className='mb-4' type='text' label='Confirm Account' />

                    <p>Select Account Type:</p>
                    <div className='d-flex justify-content-evenly mb-3 btn-outline-white rounded-pill'>
                        <MDBRadio name='accountRadio' label='Checking' defaultChecked/>
                        <MDBRadio name='accountRadio' label='Savings '/>
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