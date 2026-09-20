import { RouterProvider as ReactRouterProvider } from "react-router";
import router from "../routes/routes";

function RouterProvider() {
  return <ReactRouterProvider router={router} />;
}

export default RouterProvider;
