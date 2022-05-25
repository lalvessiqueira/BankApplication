import React, {useState} from 'react';
import './DashCustomer.css';
import DashCustomerHeader from "./DashCustomerHeader";
import DashSideBar from "./DashSideBar";
import DashCustomerAcct from "./DashCustomerAcct";
import Footer from "../Landing/Footer";
import LandingCardGroup from "../Landing/LandingCardGroup";
import CustomerFunctions from "./CustomerFunctions/CustomerFunctions";

export default function DashCustomer({setIsLoggedIn}) {
    const [view, setView] = useState('0')

    return (
        <div className="container">
            <div className="row">
                <DashCustomerHeader setView={setView} setIsLoggedIn={setIsLoggedIn}/>
            </div>
            <div>
                <section>
                    <div className="row justify-content-evenly ">
                        <div className="col-md-6 mb-3">
                            <DashSideBar setView={setView}/>
                        </div>
                        <div className="col mb-3 text-center" >
                            { (view === '0') ? <DashCustomerAcct/> : <CustomerFunctions view={view} /> }
                        </div>
                    </div>
                </section>
            </div>

            <div className="row my-5">
                <LandingCardGroup/>
            </div>
            <div className="row">
                <Footer/>
            </div>
        </div>
    );
}