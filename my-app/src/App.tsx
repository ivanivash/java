import './App.css'
import {Route, Routes} from "react-router-dom";
import DefaultLayout from "./components/containers/default/DefaultLayout.tsx";
import CategoryListPage from "./components/category/list/CategoryListPage.tsx";
import CategoryCreatePage from './components/category/create/CategoryCreatePage.tsx';


function App() {
    

  return (
    <>
        <Routes>
            <Route path={"/"} element={<DefaultLayout/>}>
                <Route index element={<CategoryListPage />} />
                <Route path={"create"} element={<CategoryCreatePage />} />
            </Route>
        </Routes>
    </>
  )
}

export default App