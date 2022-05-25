import logo from './logo.svg';
import './App.css';
import React, {useState} from "react";
import {BrowserRouter, Route, Routes} from "react-router-dom";
import UpdatePassword from "./components/ForgotPassword/UpdatePassword";
import SecQuesMismatch from "./components/ForgotPassword/SecQuesMismatch";
import Landing from "./components/Landing/Landing";
import ForgotPassword from "./components/ForgotPassword/ForgotPassword";
import Profile from "./components/CustomerDash/CustomerFunctions/Profile";
import CreateAccount from "./components/CustomerDash/CustomerFunctions/CreateAccount";
import DashCustomer from "./components/CustomerDash/DashCustomer";



//TODO: WHEN LOGGED OUT:
//localStorage.removeItem(key);
function App() {
    // const initialLog = localStorage.getItem("username");
    const [isLoggedIn, setIsLoggedIn] = useState(false);

    return (
        <React.StrictMode>
            <BrowserRouter>
                {/*<Navigation/>*/}
                <Routes>
                    <Route path="/" element={ isLoggedIn ? <DashCustomer setIsLoggedIn={setIsLoggedIn}/> : <Landing setIsLoggedIn={setIsLoggedIn}/> }/>
                    <Route path="/questionAuth" element={<ForgotPassword/>}/>
                    <Route path="/updatePassword" element={<UpdatePassword/>}/>
                    <Route path="/infoMismatch" element={<SecQuesMismatch/>}/>
                    <Route path="/profile" element={<Profile/>}/>
                    <Route path="/createAccount" element={<CreateAccount/>}/>
                </Routes>
            </BrowserRouter>
        </React.StrictMode>
    )
}

export default App;
