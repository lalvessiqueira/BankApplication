import React, {Component, useEffect, useState} from 'react';
import {
    MDBBtn,
    MDBCol, MDBContainer, MDBInput, MDBRadio, MDBRow,
    MDBTable,
    MDBTableBody,
    MDBTableHead
} from "mdb-react-ui-kit";
import axios from "axios";

export default function TransferMoney() {
    const [from, setFrom] = useState(
        {
            customerId: "",
            accountBalance: 0,
            accountNumber: 0,
            accountType: ""
        }
    );

    const [to, setTo] = useState(
        {
            accountBalance: 0,
            accountNumber: 0,
            accountType: "",
            amount: "",
            reason: ""
        }
    );

    const isSelected = (account, toFrom) => {
        console.log(toFrom)
        if (toFrom === "from") {
            if (account.accountType === "CHECKING_ACCOUNT") {
                setFrom({...from,
                    accountType: account.accountType,
                    accountBalance: account.accountBalance,
                    accountNumber: account.accountNumber
                })
            } else {
                setFrom({
                    ...from,
                    accountType: "SAVINGS_ACCOUNT",
                    accountBalance: account.accountBalance,
                    accountNumber: account.accountNumber
                })
            }
        } else {
            if (account.accountType === "CHECKING_ACCOUNT") {
                setTo({...to,
                    accountType: account.accountType,
                    accountBalance: account.accountBalance,
                    accountNumber: account.accountNumber
                })
            } else {
                setTo({...to,
                    accountType: "SAVINGS_ACCOUNT",
                    accountBalance: account.accountBalance,
                    accountNumber: account.accountNumber
                })
            }
        }
    }

    const [accounts, setAccounts] = useState([]);

    useEffect(() => {
        axios.get("http://localhost:8081/api/customer/username/" + localStorage.getItem("username"))
            .then((response) => {
                setFrom({...from, customerId: response.data.customerId})
                setAccounts({accounts: response.data.accounts})
            })
            .catch((error) => {
                console.log(error)
            });
    }, []);

    const submitHandler = (e) =>{
        const transfer = [from.accountNumber, to.accountNumber, to.amount, to.reason]
        e.preventDefault()
        if (from.accountType !== to.accountType) {
            console.log(transfer)
            // console.log("from:")
            // console.log(from)
            // console.log("to:")
            // console.log(to)
            axios.post('http://localhost:8081/api/customer/transfer', transfer).then(response => {
                console.log(response.data)
            }).catch(error => {
                console.log(error)
            })
        } else {
            alert("Same account?")
        }
    }

    return (
        <MDBContainer className='rounded-3 py-3' id='bg-glass'>
            <form onSubmit={submitHandler}>
                <MDBRow className='d-flex justify-content-start'>
                    <MDBCol>
                        <label className='mb-3'>From Account:</label>
                        <MDBTable>
                            <MDBTableHead dark>
                                <tr>
                                    <th scope='col'>Account #</th>
                                    <th scope='col'>Balance</th>
                                    <th scope='col'>Account Type</th>
                                    <th scope='col'>Select</th>
                                </tr>
                            </MDBTableHead>
                            <MDBTableBody>
                                {accounts.accounts?.map(account =>
                                    <tr>
                                        <td>{account.accountNumber}</td>
                                        <td>USD: {account.accountBalance}</td>
                                        <td>{account.accountType === "CHECKING_ACCOUNT" ? "CA" : "SB"}</td>
                                        <td>
                                            <MDBRadio name='fromAccountRadio'
                                                      value={account.accountType}
                                                      onChange={ ()=> {isSelected(account, "from")} }
                                            />
                                        </td>
                                    </tr>
                                )}
                            </MDBTableBody>
                        </MDBTable>
                    </MDBCol>
                </MDBRow>

                <MDBRow className='d-flex justify-content-center my-3'>
                    <MDBCol className=''>
                        <label className='my-3'>To Account:</label>
                        <MDBTable>
                            <MDBTableHead dark>
                                <tr>
                                    <th scope='col'>Account #</th>
                                    <th scope='col'>Balance</th>
                                    <th scope='col'>Account Type</th>
                                    <th scope='col'>Select</th>
                                </tr>
                            </MDBTableHead>
                            <MDBTableBody>
                                {accounts.accounts?.map(account =>
                                    <tr>
                                        <td>{account.accountNumber}</td>
                                        <td>USD: {account.accountBalance}</td>
                                        <td>{account.accountType === "CHECKING_ACCOUNT" ? "CA" : "SB"}</td>
                                        <td>
                                            <MDBRadio name='toAccountRadio'
                                                      value={account.accountType}
                                                      onChange={ ()=> {isSelected(account, "to")} }
                                            />
                                        </td>
                                    </tr>
                                )}
                            </MDBTableBody>
                        </MDBTable>
                    </MDBCol>
                </MDBRow>
                <MDBRow className='d-flex justify-content-center my-3'>
                    <MDBCol className='col-4'>
                        <MDBInput label='Enter Amount'
                                  name="amount"
                                  value={to.amount}
                                  onChange={(e) =>
                                      setTo({...to, amount: e.target.value})}
                        />
                    </MDBCol>
                    <MDBCol className='col-8'>
                        <MDBInput label='Include Comment'
                                  name="reason"
                                  value={to.reason}
                                  onChange={(e) =>
                                      setTo({...to, reason: e.target.value})}/>
                    </MDBCol>
                </MDBRow>
                <MDBBtn>Transfer</MDBBtn>
            </form>
        </MDBContainer>
    );
}
